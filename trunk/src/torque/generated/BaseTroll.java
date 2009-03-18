package torque.generated;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;





/**
 * Troll_s_
 *
 * This class was autogenerated by Torque on:
 *
 * [Wed Mar 18 15:20:07 CET 2009]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Troll
 */
public abstract class BaseTroll extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1237386007893L;

    /** The Peer class */
    private static final TrollPeer peer =
        new TrollPeer();


    /** The value for the nom field */
    private String nom;

    /** The value for the attaque field */
    private int attaque;

    /** The value for the degats field */
    private int degats;

    /** The value for the vie field */
    private int vie;

    /** The value for the esquive field */
    private int esquive;

    /** The value for the pa field */
    private int pa;

    /** The value for the x field */
    private int x;

    /** The value for the y field */
    private int y;

    /** The value for the idEquipArme field */
    private int idEquipArme;

    /** The value for the idEquipProtect field */
    private int idEquipProtect;


    /**
     * Get the Nom
     *
     * @return String
     */
    public String getNom()
    {
        return nom;
    }


    /**
     * Set the value of Nom
     *
     * @param v new value
     */
    public void setNom(String v) throws TorqueException
    {

        if (!ObjectUtils.equals(this.nom, v))
        {
            this.nom = v;
            setModified(true);
        }



        // update associated Sad
        if (collSads != null)
        {
            for (int i = 0; i < collSads.size(); i++)
            {
                ((Sad) collSads.get(i))
                        .setNomtroll(v);
            }
        }
    }

    /**
     * Get the Attaque
     *
     * @return int
     */
    public int getAttaque()
    {
        return attaque;
    }


    /**
     * Set the value of Attaque
     *
     * @param v new value
     */
    public void setAttaque(int v) 
    {

        if (this.attaque != v)
        {
            this.attaque = v;
            setModified(true);
        }


    }

    /**
     * Get the Degats
     *
     * @return int
     */
    public int getDegats()
    {
        return degats;
    }


    /**
     * Set the value of Degats
     *
     * @param v new value
     */
    public void setDegats(int v) 
    {

        if (this.degats != v)
        {
            this.degats = v;
            setModified(true);
        }


    }

    /**
     * Get the Vie
     *
     * @return int
     */
    public int getVie()
    {
        return vie;
    }


    /**
     * Set the value of Vie
     *
     * @param v new value
     */
    public void setVie(int v) 
    {

        if (this.vie != v)
        {
            this.vie = v;
            setModified(true);
        }


    }

    /**
     * Get the Esquive
     *
     * @return int
     */
    public int getEsquive()
    {
        return esquive;
    }


    /**
     * Set the value of Esquive
     *
     * @param v new value
     */
    public void setEsquive(int v) 
    {

        if (this.esquive != v)
        {
            this.esquive = v;
            setModified(true);
        }


    }

    /**
     * Get the Pa
     *
     * @return int
     */
    public int getPa()
    {
        return pa;
    }


    /**
     * Set the value of Pa
     *
     * @param v new value
     */
    public void setPa(int v) 
    {

        if (this.pa != v)
        {
            this.pa = v;
            setModified(true);
        }


    }

    /**
     * Get the X
     *
     * @return int
     */
    public int getX()
    {
        return x;
    }


    /**
     * Set the value of X
     *
     * @param v new value
     */
    public void setX(int v) 
    {

        if (this.x != v)
        {
            this.x = v;
            setModified(true);
        }


    }

    /**
     * Get the Y
     *
     * @return int
     */
    public int getY()
    {
        return y;
    }


    /**
     * Set the value of Y
     *
     * @param v new value
     */
    public void setY(int v) 
    {

        if (this.y != v)
        {
            this.y = v;
            setModified(true);
        }


    }

    /**
     * Get the IdEquipArme
     *
     * @return int
     */
    public int getIdEquipArme()
    {
        return idEquipArme;
    }


    /**
     * Set the value of IdEquipArme
     *
     * @param v new value
     */
    public void setIdEquipArme(int v) 
    {

        if (this.idEquipArme != v)
        {
            this.idEquipArme = v;
            setModified(true);
        }


    }

    /**
     * Get the IdEquipProtect
     *
     * @return int
     */
    public int getIdEquipProtect()
    {
        return idEquipProtect;
    }


    /**
     * Set the value of IdEquipProtect
     *
     * @param v new value
     */
    public void setIdEquipProtect(int v) 
    {

        if (this.idEquipProtect != v)
        {
            this.idEquipProtect = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collSads
     */
    protected List collSads;

    /**
     * Temporary storage of collSads to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initSads()
    {
        if (collSads == null)
        {
            collSads = new ArrayList();
        }
    }


    /**
     * Method called to associate a Sad object to this object
     * through the Sad foreign key attribute
     *
     * @param l Sad
     * @throws TorqueException
     */
    public void addSad(Sad l) throws TorqueException
    {
        getSads().add(l);
        l.setTroll((Troll) this);
    }

    /**
     * Method called to associate a Sad object to this object
     * through the Sad foreign key attribute using connection.
     *
     * @param l Sad
     * @throws TorqueException
     */
    public void addSad(Sad l, Connection con) throws TorqueException
    {
        getSads(con).add(l);
        l.setTroll((Troll) this);
    }

    /**
     * The criteria used to select the current contents of collSads
     */
    private Criteria lastSadsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getSads(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List getSads()
        throws TorqueException
    {
        if (collSads == null)
        {
            collSads = getSads(new Criteria(10));
        }
        return collSads;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Troll has previously
     * been saved, it will retrieve related Sads from storage.
     * If this Troll is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getSads(Criteria criteria) throws TorqueException
    {
        if (collSads == null)
        {
            if (isNew())
            {
               collSads = new ArrayList();
            }
            else
            {
                criteria.add(SadPeer.NOMTROLL, getNom() );
                collSads = SadPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(SadPeer.NOMTROLL, getNom());
                if (!lastSadsCriteria.equals(criteria))
                {
                    collSads = SadPeer.doSelect(criteria);
                }
            }
        }
        lastSadsCriteria = criteria;

        return collSads;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getSads(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getSads(Connection con) throws TorqueException
    {
        if (collSads == null)
        {
            collSads = getSads(new Criteria(10), con);
        }
        return collSads;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Troll has previously
     * been saved, it will retrieve related Sads from storage.
     * If this Troll is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getSads(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collSads == null)
        {
            if (isNew())
            {
               collSads = new ArrayList();
            }
            else
            {
                 criteria.add(SadPeer.NOMTROLL, getNom());
                 collSads = SadPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(SadPeer.NOMTROLL, getNom());
                 if (!lastSadsCriteria.equals(criteria))
                 {
                     collSads = SadPeer.doSelect(criteria, con);
                 }
             }
         }
         lastSadsCriteria = criteria;

         return collSads;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Troll is new, it will return
     * an empty collection; or if this Troll has previously
     * been saved, it will retrieve related Sads from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Troll.
     */
    protected List getSadsJoinTroll(Criteria criteria)
        throws TorqueException
    {
        if (collSads == null)
        {
            if (isNew())
            {
               collSads = new ArrayList();
            }
            else
            {
                criteria.add(SadPeer.NOMTROLL, getNom());
                collSads = SadPeer.doSelectJoinTroll(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SadPeer.NOMTROLL, getNom());
            if (!lastSadsCriteria.equals(criteria))
            {
                collSads = SadPeer.doSelectJoinTroll(criteria);
            }
        }
        lastSadsCriteria = criteria;

        return collSads;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Troll is new, it will return
     * an empty collection; or if this Troll has previously
     * been saved, it will retrieve related Sads from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Troll.
     */
    protected List getSadsJoinObjet(Criteria criteria)
        throws TorqueException
    {
        if (collSads == null)
        {
            if (isNew())
            {
               collSads = new ArrayList();
            }
            else
            {
                criteria.add(SadPeer.NOMTROLL, getNom());
                collSads = SadPeer.doSelectJoinObjet(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SadPeer.NOMTROLL, getNom());
            if (!lastSadsCriteria.equals(criteria))
            {
                collSads = SadPeer.doSelectJoinObjet(criteria);
            }
        }
        lastSadsCriteria = criteria;

        return collSads;
    }



        
    private static List fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList();
            fieldNames.add("Nom");
            fieldNames.add("Attaque");
            fieldNames.add("Degats");
            fieldNames.add("Vie");
            fieldNames.add("Esquive");
            fieldNames.add("Pa");
            fieldNames.add("X");
            fieldNames.add("Y");
            fieldNames.add("IdEquipArme");
            fieldNames.add("IdEquipProtect");
            fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("Nom"))
        {
            return getNom();
        }
        if (name.equals("Attaque"))
        {
            return new Integer(getAttaque());
        }
        if (name.equals("Degats"))
        {
            return new Integer(getDegats());
        }
        if (name.equals("Vie"))
        {
            return new Integer(getVie());
        }
        if (name.equals("Esquive"))
        {
            return new Integer(getEsquive());
        }
        if (name.equals("Pa"))
        {
            return new Integer(getPa());
        }
        if (name.equals("X"))
        {
            return new Integer(getX());
        }
        if (name.equals("Y"))
        {
            return new Integer(getY());
        }
        if (name.equals("IdEquipArme"))
        {
            return new Integer(getIdEquipArme());
        }
        if (name.equals("IdEquipProtect"))
        {
            return new Integer(getIdEquipProtect());
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value )
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("Nom"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setNom((String) value);
            return true;
        }
        if (name.equals("Attaque"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAttaque(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Degats"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDegats(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Vie"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setVie(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Esquive"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setEsquive(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Pa"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPa(((Integer) value).intValue());
            return true;
        }
        if (name.equals("X"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setX(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Y"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setY(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IdEquipArme"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdEquipArme(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IdEquipProtect"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdEquipProtect(((Integer) value).intValue());
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(TrollPeer.NOM))
        {
            return getNom();
        }
        if (name.equals(TrollPeer.ATTAQUE))
        {
            return new Integer(getAttaque());
        }
        if (name.equals(TrollPeer.DEGATS))
        {
            return new Integer(getDegats());
        }
        if (name.equals(TrollPeer.VIE))
        {
            return new Integer(getVie());
        }
        if (name.equals(TrollPeer.ESQUIVE))
        {
            return new Integer(getEsquive());
        }
        if (name.equals(TrollPeer.PA))
        {
            return new Integer(getPa());
        }
        if (name.equals(TrollPeer.X))
        {
            return new Integer(getX());
        }
        if (name.equals(TrollPeer.Y))
        {
            return new Integer(getY());
        }
        if (name.equals(TrollPeer.ID_EQUIP_ARME))
        {
            return new Integer(getIdEquipArme());
        }
        if (name.equals(TrollPeer.ID_EQUIP_PROTECT))
        {
            return new Integer(getIdEquipProtect());
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
      if (TrollPeer.NOM.equals(name))
        {
            return setByName("Nom", value);
        }
      if (TrollPeer.ATTAQUE.equals(name))
        {
            return setByName("Attaque", value);
        }
      if (TrollPeer.DEGATS.equals(name))
        {
            return setByName("Degats", value);
        }
      if (TrollPeer.VIE.equals(name))
        {
            return setByName("Vie", value);
        }
      if (TrollPeer.ESQUIVE.equals(name))
        {
            return setByName("Esquive", value);
        }
      if (TrollPeer.PA.equals(name))
        {
            return setByName("Pa", value);
        }
      if (TrollPeer.X.equals(name))
        {
            return setByName("X", value);
        }
      if (TrollPeer.Y.equals(name))
        {
            return setByName("Y", value);
        }
      if (TrollPeer.ID_EQUIP_ARME.equals(name))
        {
            return setByName("IdEquipArme", value);
        }
      if (TrollPeer.ID_EQUIP_PROTECT.equals(name))
        {
            return setByName("IdEquipProtect", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return getNom();
        }
        if (pos == 1)
        {
            return new Integer(getAttaque());
        }
        if (pos == 2)
        {
            return new Integer(getDegats());
        }
        if (pos == 3)
        {
            return new Integer(getVie());
        }
        if (pos == 4)
        {
            return new Integer(getEsquive());
        }
        if (pos == 5)
        {
            return new Integer(getPa());
        }
        if (pos == 6)
        {
            return new Integer(getX());
        }
        if (pos == 7)
        {
            return new Integer(getY());
        }
        if (pos == 8)
        {
            return new Integer(getIdEquipArme());
        }
        if (pos == 9)
        {
            return new Integer(getIdEquipProtect());
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
    if (position == 0)
        {
            return setByName("Nom", value);
        }
    if (position == 1)
        {
            return setByName("Attaque", value);
        }
    if (position == 2)
        {
            return setByName("Degats", value);
        }
    if (position == 3)
        {
            return setByName("Vie", value);
        }
    if (position == 4)
        {
            return setByName("Esquive", value);
        }
    if (position == 5)
        {
            return setByName("Pa", value);
        }
    if (position == 6)
        {
            return setByName("X", value);
        }
    if (position == 7)
        {
            return setByName("Y", value);
        }
    if (position == 8)
        {
            return setByName("IdEquipArme", value);
        }
    if (position == 9)
        {
            return setByName("IdEquipProtect", value);
        }
        return false;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws Exception
     */
    public void save() throws Exception
    {
        save(TrollPeer.DATABASE_NAME);
    }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
     *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
        if (!alreadyInSave)
        {
            alreadyInSave = true;



            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    TrollPeer.doInsert((Troll) this, con);
                    setNew(false);
                }
                else
                {
                    TrollPeer.doUpdate((Troll) this, con);
                }
            }


            if (collSads != null)
            {
                for (int i = 0; i < collSads.size(); i++)
                {
                    ((Sad) collSads.get(i)).save(con);
                }
            }
            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key nom ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
        setNom(key.toString());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setNom(key);
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getNom());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Troll copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public Troll copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public Troll copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Troll(), deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public Troll copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Troll(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Troll copyInto(Troll copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

  
    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    protected Troll copyInto(Troll copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected Troll copyInto(Troll copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setNom(nom);
        copyObj.setAttaque(attaque);
        copyObj.setDegats(degats);
        copyObj.setVie(vie);
        copyObj.setEsquive(esquive);
        copyObj.setPa(pa);
        copyObj.setX(x);
        copyObj.setY(y);
        copyObj.setIdEquipArme(idEquipArme);
        copyObj.setIdEquipProtect(idEquipProtect);

        copyObj.setNom((String)null);

        if (deepcopy)
        {


        List vSads = getSads();
        if (vSads != null)
        {
            for (int i = 0; i < vSads.size(); i++)
            {
                Sad obj = (Sad) vSads.get(i);
                copyObj.addSad(obj.copy());
            }
        }
        else
        {
            copyObj.collSads = null;
        }
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    protected Troll copyInto(Troll copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setNom(nom);
        copyObj.setAttaque(attaque);
        copyObj.setDegats(degats);
        copyObj.setVie(vie);
        copyObj.setEsquive(esquive);
        copyObj.setPa(pa);
        copyObj.setX(x);
        copyObj.setY(y);
        copyObj.setIdEquipArme(idEquipArme);
        copyObj.setIdEquipProtect(idEquipProtect);

        copyObj.setNom((String)null);

        if (deepcopy)
        {


        List vSads = getSads(con);
        if (vSads != null)
        {
            for (int i = 0; i < vSads.size(); i++)
            {
                Sad obj = (Sad) vSads.get(i);
                copyObj.addSad(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collSads = null;
        }
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public TrollPeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return TrollPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Troll:\n");
        str.append("Nom = ")
           .append(getNom())
           .append("\n");
        str.append("Attaque = ")
           .append(getAttaque())
           .append("\n");
        str.append("Degats = ")
           .append(getDegats())
           .append("\n");
        str.append("Vie = ")
           .append(getVie())
           .append("\n");
        str.append("Esquive = ")
           .append(getEsquive())
           .append("\n");
        str.append("Pa = ")
           .append(getPa())
           .append("\n");
        str.append("X = ")
           .append(getX())
           .append("\n");
        str.append("Y = ")
           .append(getY())
           .append("\n");
        str.append("IdEquipArme = ")
           .append(getIdEquipArme())
           .append("\n");
        str.append("IdEquipProtect = ")
           .append(getIdEquipProtect())
           .append("\n");
        return(str.toString());
    }
}
