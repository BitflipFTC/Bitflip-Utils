package club.bitflip.utils

import com.bylazar.utils.LoopTimer

object LoopTimeComponent : Component {
    private val loopTimer = LoopTimer(10)
    override fun start() {
        loopTimer.start()
    }

    override fun loop() {
        loopTimer.end()
        loopTimer.start()
        OpModeManager.telemetry.run {
            addData("Loop ms", loopTimer.ms.toDouble())
            addData("Loop hz", loopTimer.hz)
        }
    }
}