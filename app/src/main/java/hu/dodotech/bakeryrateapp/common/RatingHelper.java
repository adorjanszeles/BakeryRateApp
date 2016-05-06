package hu.dodotech.bakeryrateapp.common;

import hu.dodotech.bakeryrateapp.R;

public class RatingHelper {
    public static int getRatingResource(double rating) {
        if(rating <= 0D) { return R.drawable.zero; }
        else if(rating <= 0.5D && rating >= 0D) { return R.drawable.half; }
        else if(rating <= 1D && rating >= 0.5D) { return R.drawable.one; }
        else if(rating <= 1.5D && rating >= 1D) { return R.drawable.one_and_half; }
        else if(rating <= 2D && rating >= 1.5D) { return R.drawable.two; }
        else if(rating <= 2.5D && rating >= 2D) { return R.drawable.two_and_half; }
        else if(rating <= 3D && rating >= 2.5D) { return R.drawable.three; }
        else if(rating <= 3.5D && rating >= 3D) { return R.drawable.three_and_half; }
        else if(rating <= 4D && rating >= 3.5D) { return R.drawable.four; }
        else if(rating <= 4.5D && rating >= 4D) { return R.drawable.four_and_half; }
        else if(rating <= 5D && rating >= 4.5D) { return R.drawable.five; }
        else { return R.drawable.three_and_half; }
    }
}
