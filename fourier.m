fmuestreo = 200;
T = (1/200)*(length(datos));
w0 = 2*pi/T;
nciclos = 1;
t = 0:1/fmuestreo:nciclos*(T) - 1/fmuestreo;
ft = rot90(datos);
subplot(2,1,1);
grid on
plot(t, ft);
grid on
subplot(2,1,2);
grid on
a0 = (2/T)*trapz(t,ft);
sft = 0;
N = 1000;
for n=1:N
sft = sft + (2/T)*trapz(t,ft.*cos(n*w0*t))*cos(n*w0*t) + ... 
      (2/T)*trapz(t,ft.*sin(n*w0*t))*sin(n*w0*t); 
end
%plot(t, (((sft + a0/2))*trapz(ft)/(T))/N);
plot(t,sft);
grid on
