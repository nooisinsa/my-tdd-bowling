package tdd.bowling;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    private BowlingGame bowlingGame = new BowlingGame();

    @Test
    @DisplayName("플레이어는 모든 프레임의 각 투구에서 0점을 기록한다")
    public void gutterGame() {
        //Given: 게임을 진행하는 동안

        //When: 모든 투구에서 하나의 핀도 쓰러뜨리지 못하면
        for (int round = 1; round <= 10; round++) {
            for (int i = 1; i <= 2; i++) {
                int pin = 0;
                bowlingGame.roll(pin);
            }
        }

        //Then: 점수는 0이 된다!
        assertEquals(0, bowlingGame.score());
    }

    @Test
    @DisplayName("플레이어는 1점만 기록하고 점수를 기록하지 못한다.")
    void onePoint() {
        // Given: 일단 1점을 얻고.
        bowlingGame.roll(1);
        bowlingGame.roll(0);

        //When: 모든 투구에서 하나의 핀도 쓰러뜨리지 못하면
        for (int round = 2; round <= 10; round++) {
            for (int i = 1; i <= 2; i++) {
                int pin = 0;
                bowlingGame.roll(pin);
            }
        }

        //Then: 점수는 1이 된다!
        assertEquals(1, bowlingGame.score());
    }

    @Test
    @DisplayName("플레이어는 각 투구에서 최소 0개 최대 10개의 핀을 쓰러트릴 수 있다")
    void playerMinZeroPin() {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.roll(-1));
    }

    @Test
    @DisplayName("플레이어는 각 투구에서 최소 0개 최대 10개의 핀을 쓰러트릴 수 있다")
    void playerPinMaxTen() {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.roll(11));
    }

    @Test
    @DisplayName("플레이어는 스페어 발생 시 다음 투구에서 쓰러뜨린 핀의 개수만큼 보너스를 받는다")
    void spare() {
        //given

        //when
        bowlingGame.roll(7);
        bowlingGame.roll(3);

        bowlingGame.roll(1);
        for (int i = 0; i < 17; i++) {
            bowlingGame.roll(0);
        }

        //then
        assertEquals(12, bowlingGame.score());
    }

    @Test
    @DisplayName("플레이어는 첫 프레임에서 스트라이크를 기록하고 다음과 같은 점수를 얻는다")
    void singleStrike() {
        // given : 게임을 진행하는 동안

        // when : 첫 프레임에서 스트라이크를 기록한다.
        // 두번째 프레임의 투구들은 각 1점을 기록한다
        // 나머지 프레임은 0점을 기록한다
        bowlingGame.roll(10);
        bowlingGame.roll(1);
        bowlingGame.roll(1);
        for (int i = 0; i < 16; i++) {
            bowlingGame.roll(0);
        }

        // then : 점수는 14점이 된다
        assertEquals(14, bowlingGame.score());
    }

}