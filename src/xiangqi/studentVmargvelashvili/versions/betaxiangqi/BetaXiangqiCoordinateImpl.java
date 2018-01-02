/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.betaxiangqi;

import xiangqi.common.XiangqiCoordinate;

/**
 * @author Vato
 *
 */
public class BetaXiangqiCoordinateImpl implements XiangqiCoordinate {

	private final int rank;
	private final int file;
	
	private BetaXiangqiCoordinateImpl(int rank, int file)
	{
		this.rank = rank;
		this.file = file;
	}
	
	public static XiangqiCoordinate makeCoordinate(int rank, int file){
		return new BetaXiangqiCoordinateImpl(rank,file);
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
