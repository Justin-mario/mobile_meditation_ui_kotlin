package com.example.android.meditationui.data

import com.example.android.meditationui.R
import com.example.android.meditationui.ui.theme.Beige1
import com.example.android.meditationui.ui.theme.Beige2
import com.example.android.meditationui.ui.theme.Beige3
import com.example.android.meditationui.ui.theme.BlueViolet1
import com.example.android.meditationui.ui.theme.BlueViolet2
import com.example.android.meditationui.ui.theme.BlueViolet3
import com.example.android.meditationui.ui.theme.LightGreen1
import com.example.android.meditationui.ui.theme.LightGreen2
import com.example.android.meditationui.ui.theme.LightGreen3
import com.example.android.meditationui.ui.theme.OrangeYellow1
import com.example.android.meditationui.ui.theme.OrangeYellow2
import com.example.android.meditationui.ui.theme.OrangeYellow3

object MeditationUiObjects {
    val chips = listOf(
        "Sweet sleep",
        "Insomnia",
        "Depression",
        "Excitement",
        "Prayer")

    val features = listOf(
        Feature(
            title = "Sleep meditation",
            R.drawable.ic_headphone,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        Feature(
            title = "Tips for sleeping",
            R.drawable.ic_videocam,
            LightGreen1,
            LightGreen2,
            LightGreen3
        ),
        Feature(
            title = "Night island",
            R.drawable.ic_headphone,
            OrangeYellow1,
            OrangeYellow2,
            OrangeYellow3
        ),
        Feature(
            title = "Calming sounds",
            R.drawable.ic_headphone,
            Beige1,
            Beige2,
            Beige3
        )
    )

    val bottomMenuItems = listOf(
        BottomMenuContent("Home", R.drawable.ic_home),
        BottomMenuContent("Meditate", R.drawable.ic_bubble),
        BottomMenuContent("Sleep", R.drawable.ic_moon),
        BottomMenuContent("Music", R.drawable.ic_music),
        BottomMenuContent("Profile", R.drawable.ic_profile)

    )
}