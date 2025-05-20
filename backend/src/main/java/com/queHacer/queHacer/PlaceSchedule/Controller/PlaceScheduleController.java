package com.queHacer.queHacer.PlaceSchedule.Controller;

import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleNotValidException;
import com.queHacer.queHacer.PlaceSchedule.Model.CreatePlaceScheduleDTO;
import com.queHacer.queHacer.PlaceSchedule.Model.CreatePlaceSchedulesCommand;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceScheduleDTO;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceScheduleErrorResponse;
import com.queHacer.queHacer.PlaceSchedule.Service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place-schedule")
public class PlaceScheduleController {
    private final CreatePlaceScheduleService createPlaceScheduleService;
    private final UpdatePlaceScheduleService updatePlaceScheduleService;
    private final GetPlaceSchedulesByPlaceIdService getPlaceSchedulesByPlaceIdService;
    private final DeletePlaceScheduleService deletePlaceScheduleService;
    private final GetScheduleByIdService getScheduleByIdService;
    private final DeleteSchedulesForPlaceService deleteSchedulesForPlaceService;

    public PlaceScheduleController(CreatePlaceScheduleService createPlaceScheduleService, UpdatePlaceScheduleService updatePlaceScheduleService, GetPlaceSchedulesByPlaceIdService getPlaceSchedulesByPlaceIdService, DeletePlaceScheduleService deletePlaceScheduleService, GetScheduleByIdService getScheduleByIdService, DeleteSchedulesForPlaceService deleteSchedulesForPlaceService) {
        this.createPlaceScheduleService = createPlaceScheduleService;
        this.updatePlaceScheduleService = updatePlaceScheduleService;
        this.getPlaceSchedulesByPlaceIdService = getPlaceSchedulesByPlaceIdService;
        this.deletePlaceScheduleService = deletePlaceScheduleService;
        this.getScheduleByIdService = getScheduleByIdService;
        this.deleteSchedulesForPlaceService = deleteSchedulesForPlaceService;
    }

    @PostMapping("/place/{placeId}")
    public ResponseEntity<List<PlaceScheduleDTO>> createPlaceSchedules(
            @PathVariable Long placeId,
            @RequestBody List<CreatePlaceScheduleDTO> schedules) {

        CreatePlaceSchedulesCommand command = new CreatePlaceSchedulesCommand(placeId, schedules);
        return createPlaceScheduleService.execute(command);
    }

    @PutMapping("/place/{placeId}")
    public ResponseEntity<List<PlaceScheduleDTO>> updateSchedules(
            @PathVariable Long placeId,
            @RequestBody List<CreatePlaceScheduleDTO> schedules) {
        //I reused the creation command
        CreatePlaceSchedulesCommand command = new CreatePlaceSchedulesCommand(placeId, schedules);
        return updatePlaceScheduleService.execute(command);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<PlaceScheduleDTO>> getSchedulesByPlaceId(@PathVariable Long placeId){
        return getPlaceSchedulesByPlaceIdService.execute(placeId);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<PlaceScheduleDTO> getScheduleById(@PathVariable Long scheduleID){
        return getScheduleByIdService.execute(scheduleID);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deletePlaceSchedule(@PathVariable Long scheduleId){
        return deletePlaceScheduleService.execute(scheduleId);
    }
    @DeleteMapping("/place/{placeId}/schedules")
    public ResponseEntity<Void> deleteAllSchedulesForPlace(@PathVariable Long placeId) {
        return deleteSchedulesForPlaceService.execute(placeId);
    }


    @ExceptionHandler(PlaceScheduleNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public PlaceScheduleErrorResponse handlePlaceScheduleNotValidException(PlaceScheduleNotValidException exception){
        return new PlaceScheduleErrorResponse(exception.getMessage());
    }
}
