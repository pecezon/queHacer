import { Card, CardBody, Avatar } from "@heroui/react";

const ReseniaCard = ({ restaurant, comment, author, date, avatar, rating }) => {
  const StarRating = ({ rating }) => {
    return (
      <div className="flex items-center mb-2">
        {[1, 2, 3, 4, 5].map((star) => (
          <span 
            key={star} 
            className={
              star <= rating ? "text-yellow-400" : 
              (star - 0.5 <= rating ? "text-yellow-400 opacity-50" : "text-gray-300")
            }
          >
            ★
          </span>
        ))}
        <span className="ml-1 text-sm text-gray-500">{rating.toFixed(1)}</span>
      </div>
    );
  };

  return (
    <Card className="w-full max-w-[350px] h-[250px] shadow-lg mx-auto rounded-lg bg-white flex flex-col overflow-hidden">
                   
      <CardBody className="flex flex-col p-6 h-full">
        <div className="flex-grow">
          <h4 className="text-xl font-bold mb-1 line-clamp-1">{restaurant}</h4>
          <StarRating rating={rating} />
          <p className="text-gray-600 line-clamp-3">{comment}</p>
        </div>
        
        <div className="flex items-center mt-4 pt-3">
          <Avatar 
            size="sm"
            src={avatar}
            className="mr-3"
          />
          <div>
            <p className="font-semibold text-sm">{author}</p>
            <p className="text-gray-500 text-xs">{date}</p>
          </div>
        </div>
      </CardBody>
    </Card>
  );
};

export default ReseniaCard;
