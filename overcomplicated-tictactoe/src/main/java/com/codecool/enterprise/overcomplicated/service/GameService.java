package com.codecool.enterprise.overcomplicated.service;

import com.codecool.enterprise.overcomplicated.model.TicTacToeGame;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@Service
public class GameService {

    public void gameMove(TicTacToeGame ticTacToeGame, int playerMove) throws Exception {

        if (move(ticTacToeGame, playerMove, 1)) return;

        if (!isDraw(ticTacToeGame)) {
            int AIMove = AIMove(getTable(ticTacToeGame));
            move(ticTacToeGame, AIMove, 2);
        }

        if (isWinning(ticTacToeGame, 1)) {
            clearTable(ticTacToeGame);
            System.out.println("Player wins!");
        } else if (isWinning(ticTacToeGame, 2)) {
            clearTable(ticTacToeGame);
            System.out.println("AI wins!");
        } else if (isDraw(ticTacToeGame)) {
            clearTable(ticTacToeGame);
            System.out.println("It's draw!");
        }

    }

    private boolean move(TicTacToeGame ticTacToeGame, int move, int playerCode) {
        if (move == 0) {
            if (ticTacToeGame.getField1() == 0) {
                ticTacToeGame.setField1(playerCode);
                ticTacToeGame.getFields().set(0, ticTacToeGame.getField1());
            } else return true;
        } else if (move == 1) {
            if (ticTacToeGame.getField2() == 0) {
                ticTacToeGame.setField2(playerCode);
                ticTacToeGame.getFields().set(1, ticTacToeGame.getField2());
            } else return true;
        } else if (move == 2) {
            if (ticTacToeGame.getField3() == 0) {
                ticTacToeGame.setField3(playerCode);
                ticTacToeGame.getFields().set(2, ticTacToeGame.getField3());
            } else return true;
        } else if (move == 3) {
            if (ticTacToeGame.getField4() == 0) {
                ticTacToeGame.setField4(playerCode);
                ticTacToeGame.getFields().set(3, ticTacToeGame.getField4());
            } else return true;
        } else if (move == 4) {
            if (ticTacToeGame.getField5() == 0) {
                ticTacToeGame.setField5(playerCode);
                ticTacToeGame.getFields().set(4, ticTacToeGame.getField5());
            } else return true;
        } else if (move == 5) {
            if (ticTacToeGame.getField6() == 0) {
                ticTacToeGame.setField6(playerCode);
                ticTacToeGame.getFields().set(5, ticTacToeGame.getField6());
            } else return true;
        } else if (move == 6) {
            if (ticTacToeGame.getField7() == 0) {
                ticTacToeGame.setField7(playerCode);
                ticTacToeGame.getFields().set(6, ticTacToeGame.getField7());
            } else return true;
        } else if (move == 7) {
            if (ticTacToeGame.getField8() == 0) {
                ticTacToeGame.setField8(playerCode);
                ticTacToeGame.getFields().set(7, ticTacToeGame.getField8());
            } else return true;
        } else if (move == 8) {
            if (ticTacToeGame.getField9() == 0) {
                ticTacToeGame.setField9(playerCode);
                ticTacToeGame.getFields().set(8, ticTacToeGame.getField9());
            } else return true;
        }
        return false;
    }

    private boolean isWinning(TicTacToeGame game, int playerCode){
        return game.getField1() == playerCode && game.getField2() == playerCode && game.getField3() == playerCode ||
                game.getField4() == playerCode && game.getField5() == playerCode && game.getField6() == playerCode ||
                game.getField7() == playerCode && game.getField8() == playerCode && game.getField9() == playerCode ||
                game.getField1() == playerCode && game.getField4() == playerCode && game.getField7() == playerCode ||
                game.getField2() == playerCode && game.getField5() == playerCode && game.getField8() == playerCode ||
                game.getField3() == playerCode && game.getField6() == playerCode && game.getField9() == playerCode ||
                game.getField1() == playerCode && game.getField5() == playerCode && game.getField9() == playerCode ||
                game.getField3() == playerCode && game.getField5() == playerCode && game.getField7() == playerCode;
    }

    private boolean isDraw(TicTacToeGame game){
        for (int field: game.getFields()){
            if (field != 0) continue;
            return false;
        }
        return true;
    }

    private void clearTable(TicTacToeGame game) {
        game.setField1(0);
        game.getFields().set(0, game.getField1());
        game.setField2(0);
        game.getFields().set(1, game.getField2());
        game.setField3(0);
        game.getFields().set(2, game.getField3());
        game.setField4(0);
        game.getFields().set(3, game.getField4());
        game.setField5(0);
        game.getFields().set(4, game.getField5());
        game.setField6(0);
        game.getFields().set(5, game.getField6());
        game.setField7(0);
        game.getFields().set(6, game.getField7());
        game.setField8(0);
        game.getFields().set(7, game.getField8());
        game.setField9(0);
        game.getFields().set(8, game.getField9());
    }

    private String getTable(TicTacToeGame game) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer field : game.getFields()) {
            switch (field) {
                case 0:
                    stringBuilder.append("-");
                    break;
                case 1:
                    stringBuilder.append("O");
                    break;
                case 2:
                    stringBuilder.append("X");
            }
        }
        return stringBuilder.toString();
    }

    private String sendingGetRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // By default it is GET request
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        // Reading response from input Stream
        BufferedReader in;
        try {
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
        }catch (ConnectException e){
            return null;
        }
        String output;
        StringBuilder response = new StringBuilder();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();

        return response.toString();

    }

    private int AIMove (String table) throws Exception {
        JSONObject jsonObject;
        jsonObject = new JSONObject(Objects.requireNonNull(sendingGetRequest("http://tttapi.herokuapp.com/api/v1/" + table + "/O")));
        return Objects.requireNonNull(jsonObject).getInt("recommendation");
    }


}

