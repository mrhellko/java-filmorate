package ru.yandex.mrhellko.filmorate.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.mrhellko.filmorate.model.Film;


@RestController
@RequestMapping(value = "/films")
public class FilmController extends AbstractCrudController<Film> {

}
