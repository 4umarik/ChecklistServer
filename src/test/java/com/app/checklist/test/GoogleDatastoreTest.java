package com.app.checklist.test;

import com.app.checklist.dto.EMF;
import com.app.checklist.dto.Registration;
import com.google.appengine.api.datastore.*;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Markiyan on 20.12.14.
 */
public class GoogleDatastoreTest {

    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    @Before
    public void setUp() throws Exception {
        helper.setUp();
    }

    @After
    public void tearDown() throws Exception {
        helper.tearDown();
    }

    @Test
    public void testDataStore() throws Exception {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        Query q = new Query("Person")
                .addSort("height", com.google.appengine.api.datastore.Query.SortDirection.DESCENDING);

        PreparedQuery pq = datastore.prepare(q);
        List<Entity> entityList = pq.asList(FetchOptions.Builder.withLimit(5));
    }

    @Test
    public void testEMF() throws Exception {
        EntityManager manager = EMF.get().createEntityManager();
        javax.persistence.Query test =  manager.createQuery("select r from Registration r", Registration.class);
        List list = test.getResultList();
        manager.close();
    }
}
