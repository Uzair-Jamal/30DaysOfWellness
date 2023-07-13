package com.example.daysofwellness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DaysOfWellness(

    @StringRes val daysNumberRes: Int,
    @StringRes val daysHeadingRes: Int,
    @StringRes val daysContentRes: Int,
    @DrawableRes val daysImageRes: Int
)
