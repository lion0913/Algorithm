#include<stdio.h>
int main(void) {
	int a = 0, b = 0;
	double res;
	scanf("%d %d", &a, &b);
	if ((a > 0 && a < 10) && (b > 0 && b < 10)) {
		res = (double)a / (double)b;
		printf("%.9lf", res);
	}
	return 0;
}