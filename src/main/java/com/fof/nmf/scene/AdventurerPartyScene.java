package com.fof.nmf.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.entity.actor.GameActor;
import com.fof.nmf.entity.stats.StatBlock;
import com.fof.nmf.entity.creature.adventurer.Adventurer;
import com.fof.nmf.entity.creature.monster.Monster;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.engine.combat.CombatEngine;
import com.fof.nmf.party.GameParty;
import com.fof.nmf.scene.hud.StatBlockHud;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.SpritePaths;

public class AdventurerPartyScene extends GameScene {

    private final CombatEngine combatEngine;


    public AdventurerPartyScene(DungeonGame game) {
        super(game);

        // Party Sprites
        TextureRegion[][] t1 = TextureRegion.split(
                new Texture(
                        Gdx.files.internal(
                                SpritePaths.getBörgPath()
                        )
                ),
                16, 16
        );

        TextureRegion[][] t2 = TextureRegion.split(
                new Texture(
                        Gdx.files.internal(
                                SpritePaths.getArthaxPath()
                        )
                ),
                16, 16
        );

        GameActor s1 = new GameActor(
                new GameSprite(t1[0][0]),
                t1,
                .5f
        );

        GameActor s2 = new GameActor(
                new GameSprite(t2[0][0]),
                t2,
                .5f
        );

        // Party of two
        Adventurer a1 = new Adventurer(s1);
        Adventurer a2 = new Adventurer(s2);


        // position fix
        a1.getGameActor().setPosition(new Vector2(16, 16));
        a2.getGameActor().setPosition(new Vector2(16, 64));

        // Monster

        TextureRegion[][] tm = TextureRegion.split(
                new Texture(
                        Gdx.files.internal(
                                SpritePaths.getGangBlancPath()
                        )
                ),
                16, 16
        );

        GameActor gm = new GameActor(
                new GameSprite(tm[0][0]),
                tm,
                .5f
        );

        Monster monster = new Monster(gm);



        monster.getGameActor().setPosition(new Vector2(64, 32));

        GameParty adventureParty = new GameParty(new Adventurer[]{a1, a2}, new GameActor[]{s1, s2});

        GameParty monsterParty = new GameParty(new Monster[]{monster}, new GameActor[]{gm});



        combatEngine = new CombatEngine(adventureParty, monsterParty);

        StatBlockHud hud = new StatBlockHud(game.getGameRenderer().getSpriteBatch(), combatEngine);

        game.getGameRenderer().addGameSprite(adventureParty);
        game.getGameRenderer().addGameSprite(monsterParty);
        game.getGameRenderer().addIGameUpdate(adventureParty);
        game.getGameRenderer().addIGameUpdate(monsterParty);
        game.getGameRenderer().addIGameUpdate(combatEngine);
        game.getGameRenderer().setHud(hud);
    }

    public CombatEngine getCombatEngine() {
        return combatEngine;
    }

    @Override
    protected void handleInput(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            combatEngine.nextTurn();
        }
    }
}
