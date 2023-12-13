package com.example;

//import static org.junit.jupiter.api.Assertions.*;
//staticインポート
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
	
	private Calculator sut;
	
	// 事前処理を定義する
	@BeforeEach
	public void setUp() {
		this.sut = new Calculator();
	}
	
	@AfterEach
	public void tearDown() {
		// インスタンスの解放を必ず行う
		this.sut = null;
	}
	

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
	
	// パラメータ化
	@ParameterizedTest
	// ints = {～}のようにするとパラメータはint型となる
    // Integer.MAX_VALUEはint型の最大値である2,147,483,647で奇数
	@ValueSource(ints = {1, 3, 5, -3, -9, Integer.MAX_VALUE})
	public void 複数のパラメータが奇数であるかを検証する(int param) {
		boolean actual = sut.isOdd(param);
		boolean expected = true;
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@CsvSource({
		"6, 3, 2.0",
		"5,3,1.6666666666666667",
		"0,5,0.0"})
	// カンマ区切りの文字列をカンマで分解し、左から順に引数にセットする
	// 1つ目のパラメータでテストされるときxには6, yには3, expectedには2.0がセットされる
	public void 一度に複数のパラメータを扱う(int x, int y, double expected) {
		double actual = sut.devide(x, y);
		assertThat(actual).isEqualTo(expected);
	}
}
