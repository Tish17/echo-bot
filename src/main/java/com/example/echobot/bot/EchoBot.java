package com.example.echobot.bot;

import com.example.echobot.config.BotConfig;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
public class EchoBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    public EchoBot(BotConfig botConfig) {
        super(botConfig.getBotToken());
        this.botConfig = botConfig;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            execute(new SendMessage(update.getMessage().getChatId().toString(), update.getMessage().getText()));
            log.info("Message received: {}", update.getMessage().getText());
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }
}
