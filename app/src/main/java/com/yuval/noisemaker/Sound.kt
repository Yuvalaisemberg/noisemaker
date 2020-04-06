package com.yuval.noisemaker

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler

class Sound {
    companion object {
        fun play(context: Context, index: Int) {
            val mediaPlayer = MediaPlayer.create(context, SoundFile.getSound(index).file)

            Handler().postDelayed({
                mediaPlayer.release()
            }, mediaPlayer.duration.toLong())

            mediaPlayer.start()
        }
    }

    enum class SoundFile(val file: Int, val index: Int) {
        m_01(R.raw.m_01, 1),
        m_02(R.raw.m_02, 2),
        m_03(R.raw.m_03, 3),
        m_04(R.raw.m_04, 4),
        m_05(R.raw.m_05, 5),
        m_06(R.raw.m_06, 6),
        m_07(R.raw.m_07, 7),
        m_08(R.raw.m_08, 8),
        m_09(R.raw.m_09, 9),
        m_10(R.raw.m_10, 10),
        m_11(R.raw.m_11, 11),
        m_12(R.raw.m_12, 12),
        m_13(R.raw.m_13, 13),
        m_14(R.raw.m_14, 14);

        companion object {
            fun getSound(index: Int) = values().first {
                it.index == index
            }
        }
    }
}

