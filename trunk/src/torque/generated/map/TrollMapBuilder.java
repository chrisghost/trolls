package torque.generated.map;

import java.util.Date;
import java.math.BigDecimal;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.TableMap;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.InheritanceMap;

/**
 * Troll_s_
 *
  *  This class was autogenerated by Torque on:
  *
  * [Mon Mar 16 11:56:24 CET 2009]
  *
  */
public class TrollMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "torque.generated.map.TrollMapBuilder";

    /**
     * The database map.
     */
    private DatabaseMap dbMap = null;

    /**
     * Tells us if this DatabaseMapBuilder is built so that we
     * don't have to re-build it every time.
     *
     * @return true if this DatabaseMapBuilder is built
     */
    public boolean isBuilt()
    {
        return (dbMap != null);
    }

    /**
     * Gets the databasemap this map builder built.
     *
     * @return the databasemap
     */
    public DatabaseMap getDatabaseMap()
    {
        return this.dbMap;
    }

    /**
     * The doBuild() method builds the DatabaseMap
     *
     * @throws TorqueException
     */
    public synchronized void doBuild() throws TorqueException
    {
        if ( isBuilt() ) {
            return;
        }
        dbMap = Torque.getDatabaseMap("chrissou");

        dbMap.addTable("troll");
        TableMap tMap = dbMap.getTable("troll");
        tMap.setJavaName("Troll");
        tMap.setOMClass( torque.generated.Troll.class );
        tMap.setPeerClass( torque.generated.TrollPeer.class );
        tMap.setDescription("Troll_s_");
        tMap.setPrimaryKeyMethod("none");

        ColumnMap cMap = null;


  // ------------- Column: nom --------------------
        cMap = new ColumnMap( "nom", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "Nom" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Nom du troll");
        cMap.setInheritance("false");
        cMap.setSize( 128 );
        cMap.setPosition(1);
        tMap.addColumn(cMap);
  // ------------- Column: attaque --------------------
        cMap = new ColumnMap( "attaque", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Attaque" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Points d'attaque");
        cMap.setInheritance("false");
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: degats --------------------
        cMap = new ColumnMap( "degats", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Degats" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Points de degat");
        cMap.setInheritance("false");
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: vie --------------------
        cMap = new ColumnMap( "vie", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Vie" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Points de vie");
        cMap.setInheritance("false");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: esquive --------------------
        cMap = new ColumnMap( "esquive", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Esquive" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Points d'esquive");
        cMap.setInheritance("false");
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: pa --------------------
        cMap = new ColumnMap( "pa", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Pa" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Points d'action");
        cMap.setInheritance("false");
        cMap.setPosition(6);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
