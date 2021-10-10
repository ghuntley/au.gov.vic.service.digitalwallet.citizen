uniform mat4 u_MVPMatrix;

attribute vec4 a_VertexPosition;
attribute vec2 a_TextureCoordinates;

uniform vec3 u_AccelerometerCoordinates;

varying vec2 v_TextureCoordinates;
varying vec2 v_AccelerometerCoordinates;

void main() {
	gl_Position = u_MVPMatrix * a_VertexPosition;
	v_TextureCoordinates = a_TextureCoordinates;
	v_AccelerometerCoordinates = normalize(u_AccelerometerCoordinates).xy;
}
