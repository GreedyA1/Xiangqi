/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.alphaxiangqi;

import xiangqi.common.XiangqiCoordinate;

/**
 * @author Vato
 *
 */
public class AlphaXiangqiCoordinateImpl implements XiangqiCoordinate {

	private final int rank;
	private final int file;
	
	private AlphaXiangqiCoordinateImpl(int rank, int file)
	{
		this.rank = rank;
		this.file = file;
	}
	
	public static XiangqiCoordinate makeCoordinate(int rank, int file){
		return new AlphaXiangqiCoordinateImpl(rank,file);
	}
	
	@Override
	public int getRank(){
		return rank;
	}
	
	@Override
	public int getFile(){
		return file;
	}

}
