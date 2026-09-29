package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    void init() {
        userManager = UserManager.getInstance();
        userManager.deleteAllUser();
    }

//ーーーーー課題４ーーーーー
    @Test
    void 正常系_UserManagerインスタンス同一() {
        UserManager manager1 = UserManager.getInstance();
        UserManager manager2 = UserManager.getInstance();

        assertThat(manager1).isSameAs(manager2);
    }

    @Test
    void 正常系_userList登録参照() {
        User user1 = new User("001");
        User user2 = new User("002");

        userManager.setUserToList(user1);
        userManager.setUserToList(user2);

        assertThat(userManager.getUserList())
                .contains(user1, user2);
    }

    @Test
    void 正常系_userMap登録参照() {
        User user1 = new User("001");
        User user2 = new User("002");

        userManager.setUserToMap(user1);
        userManager.setUserToMap(user2);

        assertThat(userManager.getUserMap())
                .containsKeys("001", "002");
    }

    @Test
    void 正常系_user全削除() {
        User user1 = new User("001");
        User user2 = new User("002");

        userManager.setUserToList(user1);
        userManager.setUserToList(user2);

        userManager.setUserToMap(user1);
        userManager.setUserToMap(user2);

        userManager.deleteAllUser();

        assertThat(userManager.getUserList()).isEmpty();
        assertThat(userManager.getUserMap()).isEmpty();
    }

    @Test
    void 正常系_code指定user削除() {
        User user1 = new User("001");
        User user2 = new User("002");

        userManager.setUserToList(user1);
        userManager.setUserToList(user2);

        userManager.setUserToMap(user1);
        userManager.setUserToMap(user2);

        userManager.deleteUser("001");

        assertThat(userManager.getUserList())
                .doesNotContain(user1);

        assertThat(userManager.getUserMap())
                .doesNotContainKey("001");
    }

    @Test
    void 異常系_存在しない管理コードを指定() {
        User user1 = new User("001");

        userManager.setUserToList(user1);
        userManager.setUserToMap(user1);

        userManager.deleteUser("999");

        assertThat(userManager.getUserList())
                .contains(user1);

        assertThat(userManager.getUserMap())
                .containsKey("001");
    }

//ーーーーー課題５ーーーーー
    @Test
    void 正常系_MapList初期生成() {
        assertThat(userManager.getUserList())
                .isNotNull()
                .isEmpty();

        assertThat(userManager.getUserMap())
                .isNotNull()
                .isEmpty();
    }

    @Test
    void 正常系_List登録順序保持() {
        User user1 = new User("001");
        User user2 = new User("002");
        User user3 = new User("003");

        userManager.setUserToList(user1);
        userManager.setUserToList(user2);
        userManager.setUserToList(user3);

        assertThat(userManager.getUserList())
                .containsExactly(user1, user2, user3);
    }

    @Test
    void 正常系_Mapキー確認() {
        User user1 = new User("001");
        User user2 = new User("002");
        User user3 = new User("003");

        userManager.setUserToMap(user1);
        userManager.setUserToMap(user2);
        userManager.setUserToMap(user3);

        assertThat(userManager.getUserMap())
                .containsKeys("001", "002", "003");
    }
}
