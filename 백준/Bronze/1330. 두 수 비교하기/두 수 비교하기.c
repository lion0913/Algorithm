#include<stdio.h>
int main(void) {
	int a, b;
	scanf("%d\n%d", &a, &b);
	if ((a >= -10000 && a <= 10000) && (b >= -10000 && b <= 10000)) {
		if ((a - b) > 0) printf(">");
		else if ((a - b < 0)) printf("<");
		else printf("==");
	}
	return 0;
}