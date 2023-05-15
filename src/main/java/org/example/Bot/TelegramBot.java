package org.example.Bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.Game.Game;

public class TelegramBot extends TelegramLongPollingBot {
    private final String BOT_NAME = "RobotGame Bot";
    private final String BOT_ID = "robotgame_sqwozbab_bot";
    private final String BOT_TOKEN = "6086379728:AAF742D2ie-MAYkYtha3iJT3lMglqBAIP74";
    private Map<String, Game> GameMap = new HashMap<>();
    @Override
    public void onUpdateReceived(Update update) {
        String chatid = update.getMessage().getChatId().toString();
        String messg = update.getMessage().getText();

        SendMessage sm = new SendMessage();
        sm.setChatId(chatid);

        if (!GameMap.containsKey(chatid) && messg.equals("start")) {
            GameMap.put(chatid, new Game());
            // send preambula
            sm.setText(GameMap.get(chatid).Preambula());
            PlaceKeyboard(sm);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        else if (GameMap.containsKey(chatid)) {
            try {
                Business(update);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            Help(update);
        }
    }

    private void Business(Update update) throws TelegramApiException {
        String chatid = update.getMessage().getChatId().toString();
        String messg = update.getMessage().getText();

        SendMessage sm = new SendMessage();
        sm.setChatId(chatid);

        if (messg.equals("exit")) {
            GameMap.remove(chatid);
            Help(update);
        }
        else {
            Game g = GameMap.get(chatid);

            try {
                sm.setText(g.Update(Integer.parseInt(messg)));
            } catch (NumberFormatException e) {

            }

            // PlaceKeyboard(sm);
            // send answer

            if (!sm.getText().equals(""))
                execute(sm);

            if (g.IsEnd) {
                GameMap.remove(chatid);
                Help(update);
            }
            else {
                sm.setText(g.Preambula());
                execute(sm);
            }
        }
    }

    public void Help(Update update) {
        SendMessage sm = new SendMessage();
        sm.setChatId(update.getMessage().getChatId());
        sm.setText("Type \"start\" to start game and \"exit\" to exit game");

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void PlaceKeyboard(SendMessage sm) {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        sm.setReplyMarkup(keyboard);

        keyboard.setResizeKeyboard(true);
        keyboard.setSelective(true);
        keyboard.setOneTimeKeyboard(false);

        List<KeyboardRow> rows = new ArrayList<>();

        rows.add(new KeyboardRow());
        rows.get(0).add("1");
        rows.get(0).add("2");

        rows.add(new KeyboardRow());
        rows.get(1).add("3");
        rows.get(1).add("4");
        rows.get(1).add("5");

        rows.add(new KeyboardRow());
        rows.get(2).add("6");
        rows.get(2).add("7");
        rows.get(2).add("8");

        rows.add(new KeyboardRow());
        rows.get(3).add("start");
        rows.get(3).add("exit");

        keyboard.setKeyboard(rows);
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
