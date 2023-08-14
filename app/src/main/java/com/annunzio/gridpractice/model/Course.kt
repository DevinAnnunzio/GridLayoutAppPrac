package com.annunzio.gridpractice.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(@StringRes val courseTitleResourceId: Int,
                  val associatedCourses: Int,
                  @DrawableRes val courseImageResourceId: Int
                  )
