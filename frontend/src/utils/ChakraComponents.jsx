import React from "react";
import clsx from "clsx";

export const Box = ({ className, ...props }) => {
  return <div className={clsx("", className)} {...props} />;
};

export const Flex = ({
  className,
  direction = "row",
  align,
  justify,
  wrap,
  ...props
}) => {
  return (
    <div
      className={clsx(
        "flex",
        direction === "column" && "flex-col",
        align && `items-${align}`,
        justify && `justify-${justify}`,
        wrap && "flex-wrap",
        className
      )}
      {...props}
    />
  );
};

export const Text = ({
  className,
  size = "base",
  weight = "normal",
  ...props
}) => {
  return (
    <p
      className={clsx(`text-${size}`, `font-${weight}`, className)}
      {...props}
    />
  );
};
