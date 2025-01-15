import axios from 'axios';

// Function to fetch dealers by stateId
export const fetchDealers = async (stateId, jwtToken) => {
  try {
    const response = await axios.get(`http://localhost:8088/dealers/${stateId}`, {
      headers: {
        'Authorization': `Bearer ${jwtToken}`,
      },
    });
    return response.data;
  } catch (error) {
    console.error('Error fetching dealers:', error);
    throw error;
  }
};

// Function to fetch orders by dealerId
export const fetchOrders = async (dealerId, jwtToken) => {
  try {
    const response = await axios.get(`http://localhost:8088/orders/${dealerId}`, {
      headers: {
        'Authorization': `Bearer ${jwtToken}`,
      },
    });
    return response.data;
  } catch (error) {
    console.error('Error fetching orders:', error);
    throw error;
  }
};

export const fetchStateName = async (stateId) => {
  const response = await fetch(`http://localhost:8088/dealers/stateName/${stateId}`);
  if (!response.ok) {
    throw new Error('Error fetching state name');
  }
  const data = await response.text(); // Assuming the backend returns a plain string
  return data;
};
