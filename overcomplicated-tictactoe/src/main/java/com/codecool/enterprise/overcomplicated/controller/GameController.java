package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TicTacToeGame;
import com.codecool.enterprise.overcomplicated.service.GameService;
import com.codecool.enterprise.overcomplicated.service.GetAvatarService;
import com.codecool.enterprise.overcomplicated.service.GetComicService;
import com.codecool.enterprise.overcomplicated.service.GetFunfactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"player", "game"})
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GetFunfactService funfactService;

    @Autowired
    private GetComicService comicService;

    @Autowired
    private GetAvatarService avatarService;

    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TicTacToeGame getGame() {
        return new TicTacToeGame();
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        return avatarService.getAvatar(getPlayer().getUserName());
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        avatarService.getAvatar(player.getUserName());
        return "redirect:/game";
    }
    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player, Model model) {
        model.addAttribute("funfact", funfactService.getFunfact());
        model.addAttribute("comic_uri", comicService.getComic());
        model.addAttribute("avatar_uri", avatarService.getAvatar(player.getUserName()));
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("game") TicTacToeGame tictactoeGame,
                           @ModelAttribute("move") int move) throws Exception {
        gameService.gameMove(tictactoeGame, move);
        return "redirect:/game";
    }
}
