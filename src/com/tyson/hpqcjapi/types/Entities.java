package com.tyson.hpqcjapi.types;
/*

These files are supposed to be automatically generated. However, this is
a modification of the generated infrastructure.Entity to support multiple
entities to allow for uniform data structures for XML Parsing.

*/

import javax.xml.bind.annotation.*;

import com.tyson.hpqcjapi.utils.Logger;

import infrastructure.Entity;
import infrastructure.Entity.Fields;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for anonymous complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *<complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 * <complexType>
	 *   <complexContent>
	 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       <sequence>
	 *         <element name="Fields">
	 *           <complexType>
	 *             <complexContent>
	 *               <restriction base=
	 *                  "{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 <sequence>
	 *                   <element name="Field" maxOccurs="unbounded">
	 *                     <complexType>
	 *                       <complexContent>
	 *                         <restriction base=
	 *                            "{http://www.w3.org/2001/XMLSchema}anyType">
	 *                           <sequence>
	 *                             <element name="Value"
	 *                               type="{http://www.w3.org/2001/XMLSchema}string"
	 *                               maxOccurs="unbounded"/>
	 *                           </sequence>
	 *                           <attribute name="Name" use="required"
	 *                             type="{http://www.w3.org/2001/XMLSchema}string" />
	 *                         </restriction>
	 *                       </complexContent>
	 *                     </complexType>
	 *                   </element>
	 *                 </sequence>
	 *               </restriction>
	 *             </complexContent>
	 *           </complexType>
	 *         </element>
	 *       </sequence>
	 *       <attribute name="Type" use="required"
	 *           type="{http://www.w3.org/2001/XMLSchema}string" />
	 *     </restriction>
	 *   </complexCcontent>
	 * </complexType>
 *   </complexContent>
 * </complexType>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Entities")
public class Entities {

    @XmlElement(name = "Entity", required = true)
    protected List<Entity> entities;
    @XmlAttribute(name = "TotalResults", required = true)
    protected String count;


    public Entities(Entities entity) {
        try {
			count = "" + entity.Count();
		} catch (NumberFormatException | ParseException e) {
			Logger.logError(e.getMessage());
			count = "" + entity.getEntities().size();
		}
        entities = new ArrayList<Entity>(entity.getEntities());
    }

    public Entities() {}

    /**
     * Gets the value of the fields property.
     *
     * @return possible object is {@link Entity.Fields }
     *
     */
    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * Sets the value of the fields property.
     *
     * @param value
     *            allowed object is {@link Entity.Fields }
     *
     */
    public void setEntities(Entities value) {
        this.entities = value.getEntities();
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is {@link String }
     * @throws ParseException 
     * @throws NumberFormatException 
     *
     */
    public int Count() throws NumberFormatException, ParseException {
    	if (entities != null ) {
			if (Integer.parseInt(count) == entities.size()) {
				return Integer.parseInt(count);
			} else {
				throw( new ParseException("Meta count does not return matched count", Math.abs(Integer.parseInt(count) - entities.size())));
			}
    	} else {
    		return 0;
    	}
    }

}


