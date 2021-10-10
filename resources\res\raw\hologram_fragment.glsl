precision mediump float;

uniform sampler2D u_BackgroundTexture;
uniform sampler2D u_HologramTexture;
uniform sampler2D u_HoloMapTexture;

uniform float u_Alpha;

varying vec2 v_TextureCoordinates;
varying vec2 v_AccelerometerCoordinates;

void main() {
	vec2 redAccelerometerCoordinates = v_AccelerometerCoordinates + 0.1 * v_TextureCoordinates;
	vec2 greenAccelerometerCoordinates = v_AccelerometerCoordinates + vec2(0.333, -0.333) + 0.1 * v_TextureCoordinates;
	vec2 blueAccelerometerCoordinates = v_AccelerometerCoordinates + vec2(0.667, -0.667) + 0.1 * v_TextureCoordinates;

	vec3 backgroundColor = texture2D(u_BackgroundTexture, v_AccelerometerCoordinates).rgb;

	vec3 redHologramColor = texture2D(u_HologramTexture, redAccelerometerCoordinates).rgb;
	vec3 greenHologramColor = texture2D(u_HologramTexture, greenAccelerometerCoordinates).rgb;
	vec3 blueHologramColor = texture2D(u_HologramTexture, blueAccelerometerCoordinates).rgb;

	vec4 holoMapColor = texture2D(u_HoloMapTexture, v_TextureCoordinates);
	float backgroundWeight = 1.0 - min(1.0, holoMapColor.r + holoMapColor.g + holoMapColor.b);

	vec3 hologramColor =
		holoMapColor.r * redHologramColor +
		holoMapColor.g * greenHologramColor +
		holoMapColor.b * blueHologramColor +
		backgroundWeight * backgroundColor;

	gl_FragColor = vec4(hologramColor, holoMapColor.a * u_Alpha);
}
