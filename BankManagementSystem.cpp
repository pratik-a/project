#include<iostream>
#include<conio.h>
using namespace std;

class bank
{
	char name[20],address[50],acctype;
	int balance;
	public :
		void open_account();
		void deposit_money();
		void withdraw_money();
		void display_account();
};

void bank::open_account()
{
	cout<<"Enter your Full Name : \t";
	cin.ignore();
	cin.getline(name,20);
	cout<<"Enter your Address : \t";
	cin.ignore();
	cin.getline(address,50);
	cout<<"Enter type you want to open Saving(s)/Current(c) : \t";
	cin>>acctype;
	cout<<"Enter Amount for Deposit : \t";
	cin>>balance;
	cout<<"Your Account has been Created \n";
}

void bank::deposit_money()
{
	int amt;
	cout<<"\nEnter how much Amount you want to deposit : \t";
	cin>>amt;
	balance+=amt;
	cout<<"\nTotal Balance in account \t"<<balance;
}

void bank::display_account()
{
	cout<<"\nYour Full name : \t"<<name;
	cout<<"\nyour address : \t"<<address;
	cout<<"\ntype of account : \t"<<acctype;
	cout<<"\nDeposit amount : \t"<<balance;
}

void bank::withdraw_money()
{
	int amount;
	cout<<"\n** Withdraw **";
	cout<<"\nenter amount to withdraw : \t";
	cin>>amount;
	balance-=amount;
	cout<<"\nUpdated balance : \t"<<balance;
}

int main()
{
	int ch;
	bank obj;
	char x;
	
	do
	{
		cout<<"1) Open Account \n";
		cout<<"2) Deposit Money \n";
		cout<<"3) Withdraw Money \n";
		cout<<"4) Display Account \n";
		cout<<"5) Exit \n";
		cout<<"Select the option form above : \t";
		cin>>ch;
		
		switch(ch)
		{
			case 1: cout<<"\n\n open account \n";
			obj.open_account();
			break;
			
			case 2: cout<<"\n\n Deposit Money \n";
			obj.deposit_money();
			break;
			
			case 3: cout<<"\n\n Withdraw Money \n";
			obj.withdraw_money();
			break;
			
			case 4: cout<<"\n\n Display Money \n";
			obj.display_account();
			break;
			
			case 5: 
				if(ch == 5)
				{
					exit(1);
				}
			break;
				
			default : cout<<"\nselect valid choice \n";
		}
		
		cout<<"\nif you want to continue press Y/y else press any key\n";
		x=getch();
			
	}while(x=='Y' || x=='y');
	
	getch();
	return 0;
}
