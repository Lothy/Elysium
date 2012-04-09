package org.moparscape.elysium.entity;

import org.moparscape.elysium.entity.component.*;
import org.moparscape.elysium.net.Session;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author lothy
 */
public final class DefaultEntityFactory implements EntityFactory {

    private static final DefaultEntityFactory INSTANCE = new DefaultEntityFactory();

    public static DefaultEntityFactory getInstance() {
        return INSTANCE;
    }

    public Npc newNpc(NpcLoc loc) {
//        Map<Class<? extends Component>, Component> components =
//                new HashMap<Class<? extends Component>, Component>();
//
//        components.put(NpcLoc.class, loc);
//        components.put(Health.class, new Health());
//        components.put(Movement.class, new Movement());
//
//        for (Component c : components.values()) {
//            c.resolveDependencies(components);
//        }

        return new Npc();
    }

    public Player newPlayer(Session session) {
        Map<Class<? extends Component>, Component> components =
                new HashMap<Class<? extends Component>, Component>(30, 0.4f);

        components.put(Combat.class, new Combat());
        components.put(Communication.class, new Communication());
        components.put(Credentials.class, new Credentials());
        components.put(Skills.class, new Skills());
        components.put(UpdateProxy.class, new UpdateProxy());

        Sprite sprite = new Sprite();
        components.put(Sprite.class, sprite);

        Movement movement = new Movement();
        components.put(Movement.class, movement);

        Observer observer = new Observer();
        components.put(Observer.class, observer);

        Inventory inventory = new Inventory();
        components.put(Inventory.class, inventory);

        Bank bank = new Bank();
        components.put(Bank.class, bank);

        for (Component c : components.values()) {
            c.resolveDependencies(components);
        }

        Player player = new Player(session, components);
        sprite.setOwner(player);
        movement.setOwner(player);
        observer.setOwner(player);
        inventory.setOwner(player);
        bank.setOwner(player);

        return player;
    }
}
