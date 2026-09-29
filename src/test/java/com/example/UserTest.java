package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;

    @BeforeEach
    void init() {
        user = new User("001");
    }

//ーーーーー課題３ーーーーー
    @Test
    void 正常系_ユーザー管理コード登録参照() {
        user.setCode("002");

        assertThat(user.getCode()).isEqualTo("002");
    }

    /**
     * 正常系_名前登録参照
     */
    @Test
    void 正常系_名前登録参照() {
        user.setName("山田太郎");

        assertThat(user.getName()).isEqualTo("山田太郎");
    }

    /**
     * 正常系_年齢登録参照
     */
    @Test
    void 正常系_年齢登録参照() {
        user.setAge(20);

        assertThat(user.getAge()).isEqualTo(20);
    }

    /**
     * 異常系_範囲外年齢登録
     */
    @Test
    void 異常系_範囲外年齢登録() {
        user.setAge(200);

        assertThat(user.getAge()).isEqualTo(-1);
    }

    /**
     * 異常系_範囲外年齢登録後の値確認
     */
    @Test
    void 異常系_範囲外年齢登録後の値確認() {
        user.setAge(20);
        user.setAge(200);

        assertThat(user.getAge()).isEqualTo(20);
    }
}