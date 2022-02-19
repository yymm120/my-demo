package chapter8method;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * carefully design method signatures
 * 谨慎设计方法签名
 */
public class Demo51 {


	public Demo51() {
	}

	/**
	 * 1. 拆分方法为多个方法
	 * split method into multiple methods.
	 * 这种技巧会导致方法增多，使类变得复杂，所以建议提高方法的正交性。
	 * this trick can lead to more method and more complex class, so it is recommended to improve the orthogonality of the methods.
	 */
	public Demo51 buildDiscontinuedByOOS(){
		// do some things
		return new Demo51();
	}

	public Demo51 buildDiscontinuedByOBSFLAG(){
		// do some things
		return new Demo51();
	}

	public boolean getDiscontinued(){
		return true;
	}


	/**
	 * 2. 利用辅助类
	 * use the helper class
	 * 此时就只需要传递辅助类即可，但是辅助类的构造方法可能会传递多个参数。
	 */
	static class DiscontinuedParams{
		private Map<String, List<String>> inventoryMap = new HashMap<>();
		private boolean requireInventory;
		private String product;
		private boolean outOfStock;
		private boolean obsFlag;

		public DiscontinuedParams(Map<String, List<String>> inventoryMap, boolean requireInventory, String product, boolean outOfStock, boolean obsFlag) {
			this.inventoryMap = inventoryMap;
			this.requireInventory = requireInventory;
			this.product = product;
			this.outOfStock = outOfStock;
			this.obsFlag = obsFlag;
		}
	}

	/**
	 * 3. 利用构造方法
	 * use the construction method
	 */




	/**
	 * <h1>返回结果基础类</h1>
	 *
	 * <style type="text/css">
	 *      table
	 *      {
	 *          border-collapse: collapse;
	 *          border: none;
	 *      }
	 *      th
	 *      {
	 *          border: solid #000 1px;
	 *      }
	 *      td
	 *      {
	 *          border: solid #000 1px;
	 *      }
	 *  </style>
	 * <table cellspacing=1>
	 * <thead  bgcolor="#a1a1a1" >
	 *  <tr>
	 *      <th>字段</th>
	 *      <th>名称</th>
	 *      <th>类型</th>
	 *      <th>描述</th>
	 *  </tr>
	 * </thead>
	 * <tbody>
	 *  <tr>
	 *      <td>success</td>
	 *      <td>成功标识</td>
	 *      <td>boolean</td>
	 *      <td>true:成功， false:失败</td>
	 *  </tr>
	 *  <tr>
	 *      <td>resultMessage</td>
	 *      <td>返回信息</td>
	 *      <td>String</td>
	 *      <td>对应返回码的说明</td>
	 *  </tr>
	 *  <tr>
	 *      <td>resultCode</td>
	 *      <td>返回码</td>
	 *      <td>String</td>
	 *      <td>返回码 {@link ErrorCode}</td>
	 *  </tr>
	 * </tbody>
	 * </table>
	 *
	 * @author cdwangzijian
	 * @since 1.0.6
	 * @version 1.0.6
	 *
	 */
	public void test(){

	}
}
