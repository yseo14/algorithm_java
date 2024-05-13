#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
using namespace std;

int n;
int dp[1000001] = { 0, };

int main()
{
	cin >> n;

	dp[2] = 1;
	dp[3] = 1;

	for (int i = 4; i < 1000001; i++)
	{
		if (i % 2 != 0 && i % 3 != 0)
			dp[i] = 1 + dp[i - 1];
		else if (i % 2 == 0 && i % 3 == 0)
			dp[i] = min(1 + dp[i / 3], 1 + dp[i / 2]);
		else if (i % 2 == 0)
			dp[i] = min(1 + dp[i / 2], 1 + dp[i - 1]);
		else if(i%3==0)
			dp[i]= min(1 + dp[i / 3], 1 + dp[i - 1]);
	}
	cout << dp[n];
}