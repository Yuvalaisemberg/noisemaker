package com.yuval.noisemaker

import android.content.Context
import android.media.MediaPlayer

class Sound {
    companion object {
        private lateinit var players: List<MediaPlayer>

        fun init(context: Context) {
            players = SoundFile.values().map {
                MediaPlayer.create(context, it.file)
            }
        }

        fun play(index: Int) {
            players.get(index).start()
        }
    }

    enum class SoundFile(val file: Int, val index: Int) {
        a_0(R.raw.a_0, 0),
        a_1(R.raw.a_1, 1),
        a_2(R.raw.a_2, 2),
        a_3(R.raw.a_3, 3),
        a_4(R.raw.a_4, 4),
        a_5(R.raw.a_5, 5),
        a_6(R.raw.a_6, 6),
        a_7(R.raw.a_7, 7),
    }
}

