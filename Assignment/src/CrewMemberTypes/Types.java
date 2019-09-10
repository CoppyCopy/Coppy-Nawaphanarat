package CrewMemberTypes;

/**
 * Desc: A class that retrieves the type's informations and assigned.
 * @author sna134 and cyh27
 *
 */
public class Types {
	public String desc, name, spec;
	
	/**
	 * Desc: A construct function that receives the type's information and assigned to each variable, desc, name, and spec.
	 * @param tempDesc, a string variable that receives the description of the type.
	 * @param tempName, a string variable that receives the name of the type.
	 * @param tempSpec, a string variable that receives the special ability of the type.
	 */
	public Types(String tempDesc, String tempName, String tempSpec) {
		desc = tempDesc;
		name = tempName;
		spec = tempSpec;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSpec() {
		return spec;
	}
}
