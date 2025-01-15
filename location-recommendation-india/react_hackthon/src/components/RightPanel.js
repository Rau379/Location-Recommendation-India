import { GoogleMap, useLoadScript, Marker } from '@react-google-maps/api';

const mapContainerStyle = {
  width: '100%',
  height: '400px',
};

const center = {
  lat: 37.7749,
  lng: -122.4194,
};

const RightPanel = () => {
  const { isLoaded } = useLoadScript({
    googleMapsApiKey: "AIzaSyAlR5S0F6Y7O2ejyGtQsRhze5B9Ym2c4Mw",
  });

  if (!isLoaded) return <div>Loading...</div>;

  return (
    <GoogleMap
      mapContainerStyle={mapContainerStyle}
      zoom={10}
      center={center}
    >
      <Marker position={center} />
    </GoogleMap>
  );
};

export default RightPanel;
