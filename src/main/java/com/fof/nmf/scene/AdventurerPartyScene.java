package com.fof.nmf.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.actor.GameActor;
import com.fof.nmf.actor.StatBlock;
import com.fof.nmf.actor.adventurer.Adventurer;
import com.fof.nmf.actor.entity.GameEntity;
import com.fof.nmf.actor.monster.Monster;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.engine.combat.CombatEngine;
import com.fof.nmf.party.GameParty;
import com.fof.nmf.scene.hud.StatBlockHud;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.SpritePaths;

public class AdventurerPartyScene extends GameScene {

    private final CombatEngine combatEngine;

    private StatBlock block;


    public AdventurerPartyScene(DungeonGame game) {
        super(game);

        // Party of two
        Adventurer a1 = new Adventurer();
        Adventurer a2 = new Adventurer();

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

        GameEntity s1 = new GameEntity(
                new GameSprite(t1[0][0]),
                t1,
                .5f
        );

        GameEntity s2 = new GameEntity(
                new GameSprite(t2[0][0]),
                t2,
                .5f
        );

        // position fix
        s1.setPosition(new Vector2(16, 16));
        s2.setPosition(new Vector2(16, 64));

        // Monster
        Monster monster = new Monster();

        TextureRegion[][] tm = TextureRegion.split(
                new Texture(
                        Gdx.files.internal(
                                SpritePaths.getGangBlancPath()
                        )
                ),
                16, 16
        );

        GameEntity gm = new GameEntity(
                new GameSprite(tm[0][0]),
                tm,
                .5f
        );

        gm.setPosition(new Vector2(64, 32));

        GameParty adventureParty = new GameParty(new Adventurer[]{a1, a2}, new GameEntity[]{s1, s2});

        GameParty monsterParty = new GameParty(new Monster[]{monster}, new GameEntity[]{gm});



        combatEngine = new CombatEngine(adventureParty, monsterParty);

        block = new Adventurer();

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
