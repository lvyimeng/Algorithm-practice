#include<cstdio>  
#include<cstring>  
#include<cmath>  
#include <algorithm>  
#define FOR(i,a,n) for(int i=a;i<n;++i)  
#define REP(i,n) FOR(i,0,n)  
    using namespace std;  
class SuffixArray  
{  
public:  
    int *sa,*rank;  
    int *height;  
    int keyTypeMax,length;  
    SuffixArray(int *a,int n,int m)  
    {  
        keyTypeMax = max(m,n)+5;  
        sa = new int[n+10];  
        rank = new int[keyTypeMax];  
        height = new int[n+10];  
        length = n+1;  
        a[n] = 0;  
        setSa(a);  
        setHeight(a);  
    }  
    ~SuffixArray()  
    {  
        delete(sa);  
        delete(rank);  
        delete(height);  
    }  
    void setSa(int *a)  
    {  
        int *cnt = new int[keyTypeMax];  
        REP(i,keyTypeMax) cnt[i] = 0;  
        REP(i,length) cnt[rank[i] = a[i]]++;  
        REP(i,keyTypeMax-1) cnt[i+1] += cnt[i];  
        for(int i= length-1; i >= 0; i--) sa[--cnt[rank[i]]] = i;  
  
        int *rankSt = new int[keyTypeMax];  
        int *rankStPos = new int[length+10];  
        for(int p=0,h=1,rankMax=keyTypeMax;  
            p<length;h<<= 1,rankMax=p)  
        {  
            p = 0;  
            FOR(i,length-h,length) rankStPos[p++] = i;  
            REP(i,length) if(sa[i]>=h) rankStPos[p++] = sa[i] - h;  
            REP(i,length) rankSt[i] = rank[rankStPos[i]];  
            REP(i,rankMax) cnt[i] = 0;  
            REP(i,length) cnt[rankSt[i]]++;  
            REP(i,rankMax-1) cnt[i+1] += cnt[i];  
            for(int i=length-1;i>=0;i--) sa[--cnt[rankSt[i]]] = rankStPos[i];  
  
            swap(rank,rankSt);  
            rank[sa[0]] = 0;  
            p=1;  
            FOR(i,1,length)  
            {  
                if(rankSt[sa[i]]==rankSt[sa[i-1]]  
                &&rankSt[sa[i]+h]==rankSt[sa[i-1]+h])  
                    rank[sa[i]] = p-1;  
                else rank[sa[i]] = p++;  
            }  
        }  
        delete(rankStPos);  
        delete(rankSt);  
        delete(cnt);  
    }  
    void setHeight(int *a)  
    {  
        int h = 0;  
        REP(i,length)  
        {  
            int r = rank[i];  
            if(!r) height[r] = h = 0;  
            else  
            {  
                int pb = sa[r-1];  
                int off;  
                for(off = (h?h-1:0);a[i+off]==a[pb+off];off++) ;  
                height[r] = h = off;;  
            }  
        }  
    }  
};  
int a[1000000];  
int main()  
{  
    int i,j,k,len1,len2,len;  
    char s1[1000000];  
    scanf("%s",s1);  
    len1=strlen(s1);  
    for(i=0;i<len1;i++)  
    {  
        a[i]=s1[i];  
    }  
    a[i]=200;  
    scanf("%s",s1);  
    len2=strlen(s1);  
    for(i=0;i<len2;i++)  
    {  
        a[len1+1+i]=s1[i];  
    }  
    SuffixArray sa(a,len1+len2+1,265);  
    int ans=0,flag;  
    for(i=1;i<sa.length;i++)  
    {  
        int x,y;  
        x=min(sa.sa[i],sa.sa[i-1]);  
        y=max(sa.sa[i],sa.sa[i-1]);  
        if(x<len1&&y>len1)  
        {  
            if(ans<sa.height[i])  
            {  
                ans=sa.height[i];  
                //  flag=i;  
            }  
        }  
    }  
    /* for(i=0,len=sa.sa[flag-1];i<sa.height[flag];i++) 
    { 
    printf("%c",a[i+len]); 
    }*/  
    printf("\n");  
    printf("%d\n",ans);  
    return 0;  
}
