package com.shreerama.mblade;
import com.blade.Blade;
public class App 
{
    public static void main( String[] args )
    {
    Blade.of()
/*     .get("/basic-routes-example", ctx -> ctx.text("GET called"))
    .post("/basic-routes-example", ctx -> ctx.text("POST called"))
    .put("/basic-routes-example", ctx -> ctx.text("PUT called"))
    .delete("/basic-routes-example", ctx -> ctx.text("DELETE called")) */
    .start(App.class, args);
    }

    public void greetings(){
        System.out.println("welcome to blade world!");
    }
}