package com.example;

//import static org.junit.jupiter.api.Assertions.*;
//staticインポート
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void multiplyで3と4の乗算結果を取得する() {
		// Calculatorクラスのインスタンスを生成する
	    // テスト用のオブジェクトの変数名はよくsut(System under test、テスト対象の略)を使う
	    Calculator sut = new Calculator();
	    // 想定する計算結果の用意
	    int expected = 12;
	    
	    // 3 x 4の結果を`multiply()`に計算させる
	    int actual = sut.multiply(3,  4);

	    // 計算結果が12となるか検証する
	    assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	void multiplyで5と6の乗算結果を取得する() {
	    Calculator sut = new Calculator();
	    int expected = 30;
	    // 5 x 6の結果を`multiply()`に計算させる
	    int actual = sut.multiply(5, 6);
	    assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	void devideで3と2の除算結果を取得する() {
	    Calculator sut = new Calculator();
	    // 想定する計算結果の用意
	    double expected = 1.5;
	    // 3 ÷ 2の結果を`devide()`に計算させる
	    double actual = sut.devide(3, 2);
	    // 計算結果が1.5となるか検証する
	    assertThat(actual).isEqualTo(expected);
	}

}
