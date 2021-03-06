package com.kotlin.animationtest.property.view;

import android.animation.TypeEvaluator;
import android.graphics.Point;

public class PointSinEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        int x = (int) (startPoint.x + fraction * (endPoint.x - startPoint.x));

        int y = (int) ((Math.sin(x * Math.PI / 180) * 100) + endPoint.y / 2);
        Point point = new Point(x, y);
        return point;
    }
}