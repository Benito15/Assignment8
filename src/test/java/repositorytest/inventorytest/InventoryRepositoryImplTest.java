package repositorytest.inventorytest;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.factory.inventoryfactory.InventoryFactory;
import ac.za.cput.repositories.inventoryrepository.InventoryRepository;
import ac.za.cput.repositories.inventoryrepository.impl.InventoryRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class InventoryRepositoryImplTest {

    private InventoryRepository repository;


    @Before
    public void setUp() throws Exception {
        this.repository = InventoryRepositoryImpl.getRepository();

    }



    @Test
    public void getAll() {
        Set<Inventory> getAllInventory = this.repository.getAll();
        System.out.println("In getAllInventory, all = " + getAllInventory.size());
        Assert.assertNotNull(repository.getAll());
    }

    @Test
    public void create() {
        Inventory inventory = InventoryFactory.getInventory("Inventory",1);
        System.out.println(inventory.getInvID());
        this.repository.create(inventory);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertNotNull(this.repository.getAll().size());

    }

    @Test
    public void update() {
        Inventory inventory = InventoryFactory.getInventory("Inventory",1);
        this.repository.create(inventory);
        System.out.println(inventory);
        System.out.println("//////");
        String id ="1";
        inventory.setInvID(id);
        this.repository.update(inventory);
        System.out.println(this.repository.getAll());
        Assert.assertSame("updated version",id , inventory.getInvID());
    }

    @Test
    public void delete() {
        Inventory inventory = InventoryFactory.getInventory("Inventory",1);
        this.repository.create(inventory);
        this.repository.delete(inventory.getInvID());
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository.getAll());

    }

    @Test
    public void read() {
        Inventory inventory = InventoryFactory.getInventory("Inventory",1);
        this.repository.create(inventory);
        Inventory readInventory = this.repository.read(inventory.getInvID());
        System.out.println(readInventory);

    }


}