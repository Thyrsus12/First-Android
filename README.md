# Greek Mythology

Greek Mythology pretende acercarnos la mitología griega de forma didáctica y divertida.
La aplicación esta formada por 3 activities principales: Splash, SingIn/SingUp y Main.

## Splash

Este activity consiste en una serie de CardViews, las cuales contienen una imagen y conforman un fondo. Encima de estas, el nombre y logo de la app.

<img src="/img/splash.gif" width="300px" height="500px"/>

La base del activity es un Constraint-Layout que contiene los CardViews y estos sus respectivas imágenes, con una elevacion superior econtramos un View que actua de velo para permitir que el logo (ImageView) y el nombre de la app (TextView) se vea bien sobre las imagenes.

Además, las CardView están animadas de tal forma que suben todas hacia arriba desplazandose por la pantalla. Tras unos instantes se lanza automaticamente el activity SingIn

## SingIn

Activity formado por un fondo sobre el que se muestran el logo de la imagen, dos campos para introducir **Usuario** y **Contraseña**, un botón para iniciar sesión y otro para poder registrarse.

<img src="/img/signin.png" width="300px" height="500px"/>

Esta formada por un Constraint-Layout que contiene:

- View: establece un gradiante de fondo.
- ImageView: Muestra el logo de la app.
- TextInput: Campos editables de **Usuario** y **Contraseña**.
- Button: Botón para iniciar sesion que abre el **Activity-Main**.
- TextView: Texto que invita a registrarse que ademas contiene una acción que al pulsar lanza el **Activity-SignUp**.

## SingUp

Este activity sigue el mismo concepto que el SingUp, formado por:

<img src="/img/signup.png" width="300px" height="500px"/>

- View: establece un gradiante de fondo.
- ImageView: Muestra el logo de la app.
- TextInput: Campos editables de **Nombre**, **Email**, **Usuario** y **Contraseña**.
- Button: Botón para registrarse.

## Main
Formado por:

- SwipeRefresh: contiene un WebView y perimte actualizarlo.
- WebView: carga una pagina para ver su contenido.
- ToolBar: menú con varios botones que generan Toast y una notificacion.

<img src="/img/main.gif" width="300px" height="500px"/>
