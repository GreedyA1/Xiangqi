/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.commonFiles;

import xiangqi.common.XiangqiCoordinate;

/**
 * @author Vato
 *
 */
public class TheXiangqiCoordinateImpl implements XiangqiCoordinate {

	private final int rank;
	private final int file;
	
	private TheXiangqiCoordinateImpl(int rank, int file)
	{
		this.rank = rank;
		this.file = file;
	}
	
	public static XiangqiCoordinate makeCoordinate(int rank, int file){
		return new TheXiangqiCoordinateImpl(rank,file);
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
