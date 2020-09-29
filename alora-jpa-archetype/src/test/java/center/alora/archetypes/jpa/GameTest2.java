package center.alora.archetypes.jpa;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
//import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class GameTest2 {

	@Deployment
    public static Archive<?> createDeployment() {
        JavaArchive archJar = ShrinkWrap.create(JavaArchive.class)
            .addPackage(Game.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(archJar);
        return archJar;
    }
	
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	@UsingDataSet("datasets/games.yml")
	public void test() {
		List<Game> games = em.createQuery("SELECT g FROM Game g", Game.class).getResultList();
		for(Game game : games) {
			System.out.println(game);
			System.out.println(game.getCategory());
		}
		
		List<Category> categories = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
		for(Category c : categories) {
			System.out.println(c.getCategory());
		}
	}
}

