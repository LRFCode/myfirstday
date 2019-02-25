package controllers;

import models.Words;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;

public class GameController extends Controller
{
    private FormFactory formFactory;

    @Inject
    public GameController(FormFactory formFactory)
    {
        this.formFactory = formFactory;
    }

    public Result getStartPage()
    {
        return ok(views.html.start.render());
    }

    public Result getFirstStory()
    {
        Words words = new Words();
        words.setPlace1("Zoo");

        return ok(views.html.story.render(words, "shopping.png", "thirdstory", "secondstory"));
    }

    public Result getSecondStory()
    {
        Words words = new Words();
        words.setPlace1("Farm");

        return ok(views.html.story.render(words, "snow.png", "firststory", "thirdstory"));
    }

    public Result getThirdStory()
    {
        Words words = new Words();
        words.setPlace1("Farm");

        return ok(views.html.story.render(words, "hoff.jpg", "secondstory", "firststory"));
    }

    public Result getNewStory()
    {
        return ok(views.html.newstory.render());
    }

    public Result postNewStory(Http.Request request)
    {
        DynamicForm form = formFactory.form().bindFromRequest(request);
        String place1 = form.get("place1");

        Words words = new Words();
        words.setPlace1(place1);

        return ok(views.html.story.render(words, "hoff.jpg", "firststory", "secondstory"));
    }
}
