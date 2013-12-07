declare @paragraph varchar(500)
set @paragraph='Here is a test sentence with a {Term1}. Sometime, a {Term2} could be a word or phrase like {Phrase Term3}. {Term2} is repeated. Some Terms could be a plural form of a another Term like {Term2}s. Here is a real {Simple} Term.'
declare @N int
set @N=0
declare @c char(1),@word varchar(50)
set @word=''

while @n<=len(@paragraph)
begin
set @c=substring(@paragraph,@n,1)
set @n=@n+1

if @c='{'
begin
set @c=substring(@paragraph,@n,1)
set @n=@n+1

while @c!='}'
begin
set @word=@word+@c
set @c=substring(@paragraph,@n,1)
set @n=@n+1
end

print @word
set @word=''
set @n=@n+1

end

end
