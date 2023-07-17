head -1 file.txt | wc -w | xargs seq 1 | xargs -I{} -n 1 sh -c "cut -d ' ' -f{} file.txt | paste -sd ' ' -"
head -1 file.txt | wc -w | xargs seq | xargs -n1 -I{} sh -c "cut -d' ' -f{} file.txt | xargs"

awk '
{
    for (i = 1; i <= NF; i++)  {
        a[NR, i] = $i
    }
}
NF > p { p = NF }
END {
    for (j = 1; j <= p; j++) {
        str = a[1, j]
        for (i = 2; i <= NR; i++){
            str = str " " a[i, j]
        }
        print str
    }
}' file.txt