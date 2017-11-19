public class s2ej1 {
	public static void main (String[] args){
		int hora, achora, min, seg, amin, aseg;
		aseg = 75936/60;
		seg = 75936%60;
		amin = aseg/60;
		min = aseg%60;
		achora = amin/60;
		hora = amin;
		System.out.println(hora + ":" + min + ":" + seg);		
	}
}
