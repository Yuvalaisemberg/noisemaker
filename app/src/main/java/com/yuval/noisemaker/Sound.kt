package com.yuval.noisemaker

import android.content.Context
import android.media.MediaPlayer

public class Sound {

    companion object {
        fun play(context: Context, sound: SoundFile) {
            MediaPlayer.create(context, sound.file).start()
        }
    }

    enum class SoundFile(val file: Int) {
        a_0(R.raw.a_0),
        a_1(R.raw.a_1),
        a_2(R.raw.a_2),
        a_3(R.raw.a_3),
        a_4(R.raw.a_4),
        a_5(R.raw.a_5),
        a_6(R.raw.a_6),
        a_7(R.raw.a_7),
    }
}

