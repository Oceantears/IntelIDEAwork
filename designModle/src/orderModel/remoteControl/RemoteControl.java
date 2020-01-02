/**
 * <一句话功能简述>
 * <p>
 * 遥控器处理
 *
 * @author sunmeng
 * @create 2019/12/30   11:05
 */
package orderModel.remoteControl;

public class RemoteControl {
	//遥控器处理七个开与关的命令，使用相应数组记录这些命令
	Command[] onCommands;
	Command[] offCommands;
	public RemoteControl(){
		onCommands=new Command[7];
		offCommands=new Command[7];

		Command noCommand=new NoCommand();
		for(int i=0;i<7;i++){
			onCommands[i]=noCommand;
			offCommands[i]=noCommand;
		}
	}
	public void setCommand(int slot,Command onCommand,Command offCommad){
		onCommands[slot]=onCommand;
		offCommands[slot]=offCommad;
	}
	public void onButtonWasPushed(int slot){
		onCommands[slot].execute();
	}
	public void offButtonWasPushed(int slot){
		offCommands[slot].execute();
	}
	@Override
	public String toString(){
		StringBuffer stringBuff=new StringBuffer();
		stringBuff.append("\n==========Remote Control=============\n");
		for(int i=0;i<onCommands.length;i++){
			stringBuff.append("[slot "+i+"]"+onCommands[i].getClass().getName()+"	"+offCommands[i].getClass().getName()+"\n");
		}
		return stringBuff.toString();
	}
}
