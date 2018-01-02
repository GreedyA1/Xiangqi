/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.deltaxiangqi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import xiangqi.XiangqiGameFactory;
//import xiangqi.XiangqiGameFactory.DeltaXiangqiCoordinateImpl;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentVmargvelashvili.versions.commonFiles.TheXiangqiCoordinateImpl;
/**
 * @author Vakhtang Margvelashvili
 *
 */
public class DeltaXiangqiTestCase {
	
	private XiangqiGame gameD;
	private XiangqiGame gameA;
	private XiangqiGame gameB;
	private XiangqiGame gameG;
	
	@Before
	public void setup(){
		gameD = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.DELTA_XQ);
		//gameA = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.ALPHA_XQ);
		//gameB = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.BETA_XQ);
		//gameG = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.GAMMA_XQ);
	}
	
	@Test 
	public void test() {
		assertNotNull(XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.DELTA_XQ));
	}

	@Test 
	public void testMoveOutside(){
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(-1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, -3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(11, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 13), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, -1)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(-3, 1)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(31, 1)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 11)));
	}
	
	@Test 
	public void testElephantMove(){
		System.out.println("==========================================================================================================================");
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 1), TheXiangqiCoordinateImpl.makeCoordinate(5, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 1), TheXiangqiCoordinateImpl.makeCoordinate(5, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 5)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 3), TheXiangqiCoordinateImpl.makeCoordinate(7, 5))); // trying to get over the river
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 5))); //retrying the move with correct coordinates
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 5), TheXiangqiCoordinateImpl.makeCoordinate(1, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 5), TheXiangqiCoordinateImpl.makeCoordinate(1, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(XiangqiPieceType.ADVISOR, gameD.getPieceAt(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), XiangqiColor.RED).getPieceType());
		assertEquals(XiangqiColor.RED, gameD.getPieceAt(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), XiangqiColor.RED).getColor());
	}
	
	@Test 
	public void testAdvisorMove(){
		System.out.println("=========================================================testAdvisorMove");
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 3)));
		System.out.println(gameD.getMoveMessage());
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		System.out.println(gameD.getMoveMessage());
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 5), TheXiangqiCoordinateImpl.makeCoordinate(3, 6)));
		System.out.println(gameD.getMoveMessage());
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 5), TheXiangqiCoordinateImpl.makeCoordinate(3, 6)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 6), TheXiangqiCoordinateImpl.makeCoordinate(4, 7)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 6), TheXiangqiCoordinateImpl.makeCoordinate(2, 7)));
	}
	
	@Test 
	public void testChariotMove(){
		System.out.println("=========================================================testChariotMove");
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 1), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 1), TheXiangqiCoordinateImpl.makeCoordinate(8, 1)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 1), TheXiangqiCoordinateImpl.makeCoordinate(2, 1)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 1), TheXiangqiCoordinateImpl.makeCoordinate(2, 1)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 1), TheXiangqiCoordinateImpl.makeCoordinate(2, 6)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 1), TheXiangqiCoordinateImpl.makeCoordinate(2, 2)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 6), TheXiangqiCoordinateImpl.makeCoordinate(8, 6)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 2), TheXiangqiCoordinateImpl.makeCoordinate(2, 4)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(8, 6), TheXiangqiCoordinateImpl.makeCoordinate(8, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 4), TheXiangqiCoordinateImpl.makeCoordinate(6, 4)));
	}
	
	@Test 
	public void testCannonMove(){
		System.out.println("=========================================================testCannonMove");
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 2), TheXiangqiCoordinateImpl.makeCoordinate(3, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));	
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 3), TheXiangqiCoordinateImpl.makeCoordinate(5, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 3), TheXiangqiCoordinateImpl.makeCoordinate(7, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 8), TheXiangqiCoordinateImpl.makeCoordinate(10, 8)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(7, 3), TheXiangqiCoordinateImpl.makeCoordinate(7, 7)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(10, 8), TheXiangqiCoordinateImpl.makeCoordinate(10, 6)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(7, 7), TheXiangqiCoordinateImpl.makeCoordinate(10, 7)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(10, 6), TheXiangqiCoordinateImpl.makeCoordinate(10, 4)));
		assertEquals(MoveResult.RED_WINS, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(10, 7), TheXiangqiCoordinateImpl.makeCoordinate(10, 5)));
	}
	
	@Test 
	public void testGeneralMove(){
		System.out.println("=========================================================testGeneralMove");
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 5), TheXiangqiCoordinateImpl.makeCoordinate(3, 5)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 5), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 5), TheXiangqiCoordinateImpl.makeCoordinate(1, 6)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 5), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 5), TheXiangqiCoordinateImpl.makeCoordinate(2, 4)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 5), TheXiangqiCoordinateImpl.makeCoordinate(3, 5)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 4), TheXiangqiCoordinateImpl.makeCoordinate(3, 4)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 5), TheXiangqiCoordinateImpl.makeCoordinate(4, 5)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 5), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 4), TheXiangqiCoordinateImpl.makeCoordinate(3, 2)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 4)));
	}
	
	@Test 
	public void testSoldierMove(){
		System.out.println("=========================================================testSoldierMove");
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(4, 5), TheXiangqiCoordinateImpl.makeCoordinate(5, 5)));
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(4, 1), TheXiangqiCoordinateImpl.makeCoordinate(4, 2)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(4, 1), TheXiangqiCoordinateImpl.makeCoordinate(5, 1)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 5), TheXiangqiCoordinateImpl.makeCoordinate(6, 5)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 1), TheXiangqiCoordinateImpl.makeCoordinate(6, 1)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(6, 5), TheXiangqiCoordinateImpl.makeCoordinate(7, 5)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(6, 1), TheXiangqiCoordinateImpl.makeCoordinate(7, 1)));
		assertEquals(MoveResult.BLACK_WINS, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(7, 5), TheXiangqiCoordinateImpl.makeCoordinate(7, 4)));
	}
	
	@Test 
	public void testHorseMove(){
		System.out.println("=========================================================testSoldierMove");
		assertEquals(MoveResult.ILLEGAL, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 2), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 2), TheXiangqiCoordinateImpl.makeCoordinate(3, 6)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 2), TheXiangqiCoordinateImpl.makeCoordinate(3, 6)));	
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 2), TheXiangqiCoordinateImpl.makeCoordinate(3, 3)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 2), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 3), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		assertEquals(MoveResult.OK, gameD.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 1), TheXiangqiCoordinateImpl.makeCoordinate(2, 3)));
	}
	
}



